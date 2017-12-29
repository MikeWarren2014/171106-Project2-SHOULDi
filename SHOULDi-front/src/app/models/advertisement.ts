import { Post } from "./post";

export class Advertisement extends Post{
    _id     : number;
    url     : string;
    clicks  : number;
    skips   : number;
}