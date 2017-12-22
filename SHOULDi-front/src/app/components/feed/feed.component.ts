import { Component,OnInit } from "@angular/core";
import { User } from "../../models/user"
import { UserService } from "../../services/user.service"
@Component({
    selector: 'home',
    templateUrl: './home.component.html',
    styleUrls: []
})

export class FeedComponent
{
    currentUser: User;
    users: User[] = [];
    constructor(private userService: UserService){
        this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
    }
    ngOnInit() {
    }
    deleteUser(id: string){
        this.userService.delete(id).subscribe(() => { this.loadAllUsers() });
    }
    private loadPosts() {
        this.userService.getAll().subscribe(users => { this.users = users; });
    }
}