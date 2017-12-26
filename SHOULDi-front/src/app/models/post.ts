
export class Post {
    _id         : number;
    postDate    : Date;
    image       : Blob;
    occasion    : string;
    comments    : Comment[]; 
    likes       : number;
    dislikes    : number;
    isFlagged   : boolean;
}