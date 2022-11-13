import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ACTIONS } from '@shared/constants/constant';
import { AuthService } from '../services/auth.services';
import { Router } from '@angular/router';
import {
  SignInWithPasswordCredentials,
  SignUpWithPasswordCredentials,
  User,
} from '@supabase/gotrue-js';
import { ToastrService } from 'ngx-toastr';
import { AuthError } from '@supabase/supabase-js';


export interface OptionsForm {

  id: string;
  label: string;
}

interface UserResponse extends User, AuthError {}

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss'],
})
export class FormComponent implements OnInit {
  authForm!: FormGroup;
  signIn = ACTIONS.signIn;
  @Input() options!: OptionsForm;

  constructor(
    private readonly authSvc: AuthService,
    private readonly fb: FormBuilder,
    private readonly router: Router,
    private readonly toastSvc: ToastrService,
  ) {

  }

  ngOnInit(): void {
    this.initForm();
  }

  async onSubmit(): Promise<void> {
    console.log('Save', this.authForm.value)
    const credentials: SignInWithPasswordCredentials = this.authForm.value;
    let actionToCall = this.authSvc.signUp(credentials);

    if (this.options.id === ACTIONS.signIn) {
      actionToCall = this.authSvc.signIn(credentials);
    }

    try {
      const result = await actionToCall as UserResponse;
      console.log(result);
      if (result.email !=='') { //Falta validar bien
        //Redicy Home Page
        this.redirectUser();
        console.log('Home -->');
      } else {
        console.log('Notificación -->');
        this.toastSvc.info(result.message, 'Info');
      }
    } catch (error) {
      console.log(error);
    }
  }

  private initForm(): void {
    this.authForm = this.fb.group({
      email: ['', Validators.required],
      password: ['', Validators.required],
    });
  }

  private redirectUser(): void {
    this.router.navigate(['/home']);
  }


}
