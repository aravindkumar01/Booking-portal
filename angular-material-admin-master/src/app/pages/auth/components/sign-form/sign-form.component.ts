import { Users } from './../../../model/users/users';


import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../services';

@Component({
  selector: 'app-sign-form',
  templateUrl: './sign-form.component.html',
  styleUrls: ['./sign-form.component.scss']
})
export class SignFormComponent implements OnInit {
  @Output() sendSignForm = new EventEmitter<void>();
  public form: FormGroup;

  user:Users=new Users();
  status:string;

  constructor(
    private service: AuthService,
    private router: Router
  ) { }
  
  public ngOnInit(): void {
    this.form = new FormGroup({
      name: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required])
    });
  }

  public sign(): void {
    if (this.form.valid) {
        console.log(this.form.controls);
         
       
        this.user.role="USER";        
        console.log(this.user);
        this.service.sign(this.user).subscribe(data => {          
          console.log("data::"+data);
            if(!data.includes("already")){
              this.user=new Users();
            }
            this.status=data;
          
      });
    }
  }
}
