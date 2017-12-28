import { User } from "./user";

export class Comment
{
    _id          : number = null;
    commenter    : User;
    content      : string;
    isFlagged    : boolean;
}
