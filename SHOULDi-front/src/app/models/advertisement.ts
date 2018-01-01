import { Post } from "./post";

export class Advertisement extends Post{
    _id     : number;
    url     : string;
    amount : number;
    clicks  : number;
    views   : number;
}