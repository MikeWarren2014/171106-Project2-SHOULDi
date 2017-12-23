
export class Post {
    _id         : number;
    postDate    : Date;
    image       : Blob;
    comments    : Comment[]; 
    likes       : number;
    dislikes    : number;
    isFlagged   : boolean;
}