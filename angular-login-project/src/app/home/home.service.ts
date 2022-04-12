import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, retry, throwError } from 'rxjs';
import { AuthenticationService } from '../login/auth.service';
import { User } from '../settings/settings.component';

export class Source {
    id?: string;
    name?: string;
}

export class Article {
    source?: Source;
    author?: string;
    title?: string;
    description?: string;
    url?: string;
    urlToImage?: string;
    publishedAt?: string;
    content?: string;
}

export class NewsResponse {
    status?: string;
    totalResults?: number;
    articles?: Article[];
}

@Injectable({
    providedIn: 'root'
})
export class HomeService {
    constructor(private http: HttpClient, private authenticationService: AuthenticationService) {
    }

    getGeneralNews(): Observable<NewsResponse> {
        let username = this.authenticationService.getLoggedInUserName();
        if (!this.authenticationService.isUserLoggedIn()) {
            username = 'defaultuser';
        }
        return this.http
            .get<NewsResponse>('http://localhost:8080/news/' + username)
            .pipe(retry(1), catchError(this.handleError));

    }

    getCategoryNews(category: string): Observable<NewsResponse> {
        return this.http
            .get<NewsResponse>('http://localhost:8080/news/category/' + category)
            .pipe(retry(1), catchError(this.handleError));

    }

    getUser(username: string) {
        return this.http
            .get('http://localhost:8080/users/getUser?username=' + username)
            .pipe(retry(1), catchError(this.handleError));
    }

    handleError(error: any) {
        let errorMessage = '';
        if (error.error instanceof ErrorEvent) {
            errorMessage = error.error.message;
        } else {
            errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
        }
        window.alert(errorMessage);
        return throwError(() => {
            return errorMessage;
        });
    }

}