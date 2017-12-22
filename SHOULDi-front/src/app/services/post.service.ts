import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';

import { Post } from '../models/post';
import 'rxjs/';

@Injectable()
export class PostService{
    // TODO: get the endpoints
    constructor(private http: Http) {}
    getSomeFeed(){
        return this.http.get('/posts/feed').map((res : Response) => res.json());
    }
    getSomePosts(_id: string){
        return this.http.get('/posts/' + _id).map((res: Response) => res.json());
    }
    create(post: Post){
        return this.http.post('/posts/create', post);
    }
    update(post: Post){
        return this.http.put('/posts/' + post._id, post);
    }
    delete(_id: string){
        return this.http.delete('/posts/' + _id);
    }
}