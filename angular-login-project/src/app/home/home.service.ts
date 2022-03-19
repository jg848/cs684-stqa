import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, retry, throwError } from 'rxjs';
import { AuthenticationService } from '../login/auth.service';
import { MessageModel } from '../message';

export class Source {
    id?: string;
    name?: string;
}

export class Article {
    source?: Source;
    author? : string;
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
    executeHomeService() {
        return this.http.post<MessageModel>('http://localhost:8080/users/signin', '');
    }

    getGeneralNews(): Observable<NewsResponse> {
        let username = this.authenticationService.getLoggedInUserName();
        if(!this.authenticationService.isUserLoggedIn()){
            username = 'defaultuser';
        }
        return this.http
            .get<NewsResponse>('http://localhost:8080/news/' + username + '/general')
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