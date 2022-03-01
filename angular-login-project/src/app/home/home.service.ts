import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MessageModel } from '../message';

@Injectable({
    providedIn: 'root'
})
export class HomeService {
    constructor(private http: HttpClient) {
    }
    executeHomeService() {
        return this.http.post<MessageModel>('http://localhost:8080/users/signin', '');
    }
}