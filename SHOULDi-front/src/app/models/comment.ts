import { User } from "./user";

export class Comment
{
    _id          : number;
    _commenterId : number;
    commenter    : User;
    content      : string;
    isFlagged    : boolean;
}
