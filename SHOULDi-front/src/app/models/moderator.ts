import { User } from "./user"
import { UserRoles } from "./userRoles";
export class Moderator extends User{
    role = UserRoles.MODERATOR;
}