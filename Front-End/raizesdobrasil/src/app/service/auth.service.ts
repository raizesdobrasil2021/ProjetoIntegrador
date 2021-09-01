import { UsuarioLogin } from './../model/UsuarioLogin';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UsuarioReq } from '../model/UsuarioReq';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  [x: string]: any;

  constructor(
    private http: HttpClient
  ) { }

entrar(usuarioLogin: UsuarioLogin): Observable<UsuarioLogin> {
  return this.http.post<UsuarioLogin>('https://raizesdobrasil.herokuapp.com/usuarios/logar', usuarioLogin)
}

cadastrar(usuario: UsuarioReq): Observable<UsuarioReq>{
  return this.http.post<UsuarioReq>('https://raizesdobrasil.herokuapp.com/usuarios/cadastrar', usuario)
}

}
