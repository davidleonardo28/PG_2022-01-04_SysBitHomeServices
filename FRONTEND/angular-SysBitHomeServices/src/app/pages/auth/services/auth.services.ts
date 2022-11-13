import { Injectable } from "@angular/core";
import { Data } from "@angular/router";
import { environment } from "@env/environment";
import { USER_STORAGE_KEY } from "@shared/constants/constant";
import { createClient, Session, SupabaseClient, User,SignInWithPasswordCredentials, SignUpWithPasswordCredentials, AuthError} from "@supabase/supabase-js";
import { BehaviorSubject, Observable } from "rxjs";

type supabaseResponse = Data | Session | AuthError |null;

@Injectable({ providedIn: 'root' })
export class AuthService {
  private supabaseClient: SupabaseClient;
  private userSubject = new BehaviorSubject<User | null>(null);

  constructor() {
    this.supabaseClient = createClient(environment.supabase.url, environment.supabase.publicKey);
    this.setUser();
  }

  get user$(): Observable<User | null> {
    return this.userSubject.asObservable();
  }
  async signIn(credentials: SignInWithPasswordCredentials ): Promise<supabaseResponse> {
    try {
      const { data, error, ...rest } = await this.supabaseClient.auth.signInWithPassword(credentials);
      this.setUser();
      return { data, error }
    } catch (error) {
      console.log(error);
      return error as AuthError;
    }
  }


  async signUp(credentials: SignUpWithPasswordCredentials): Promise<supabaseResponse> {
    try {
      const { data, error, ...rest } = await this.supabaseClient.auth.signUp(credentials);
      this.setUser();
      return { data, error }
    } catch (error) {
      console.log(error);
      return error as AuthError;
    }
  }

  signOut(): Promise<{ error: AuthError | null }> {
    this.userSubject.next(null);
    return this.supabaseClient.auth.signOut();
  }


  private setUser(): void {
    const session = localStorage.getItem(USER_STORAGE_KEY) as unknown as User;
    this.userSubject.next(session);
  }
}
