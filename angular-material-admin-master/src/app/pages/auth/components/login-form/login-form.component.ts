import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../services';
import { Router } from '@angular/router';
import { Loginuser } from 'src/app/pages/model/loginuser/loginuser';
import { Constants } from 'src/app/pages/model/constants';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.scss']
})
export class LoginFormComponent implements OnInit {
  constructor(
    private service: AuthService,
    private router: Router
  ) { }
  
  loginUser:Loginuser=new Loginuser();
  public form: FormGroup;
  public flatlogicEmail = 'admin@flatlogic.com';
  public flatlogicPassword = 'admin';

  public ngOnInit(): void {
    this.form = new FormGroup({
      email: new FormControl(this.flatlogicEmail, [Validators.required, Validators.email]),
      password: new FormControl(this.flatlogicPassword, [Validators.required])
    });
  }

  public login(): void {
    if (this.form.valid) {

      this.loginUser.username=this.form.controls.email.value;
      this.loginUser.password=this.form.controls.password.value;
      this.service.login(this.loginUser).subscribe(data=>{

        localStorage.setItem('token',  data.token);
          console.log(data);

         const role=Constants.userRole();    
              if(role=="ROLE_USER"){
                this.router.navigate(['/customer']);
              }
          });
      //this.sendLoginForm.emit();
    }
  }
}
