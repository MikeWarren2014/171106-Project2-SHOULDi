
export class Post {
    _id         : number;
    _posterId   : number;
    _imageId    : number;
    imageUrl    : string;
    isFlagged   : boolean;
    comments    : Comment[]; 
    timestamp   : number;
}