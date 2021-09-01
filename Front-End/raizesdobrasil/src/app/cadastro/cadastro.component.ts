import { Component, OnInit } from '@angular/core';
import { UsuarioReq } from '../model/UsuarioReq';
import { UsuarioLogin } from '../model/UsuarioLogin';
import { AuthService } from '../service/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {
  usuario: UsuarioReq = new UsuarioReq;
  confirmarSenha: string;
  tipoUsuario: string;

  constructor(
    private authService: AuthService,
    private router: Router
  ) { }

  ngOnInit() {
    window.scroll(0, 0)
  }
  confirmSenha(event: any) {
    this.confirmarSenha = event.target.value;
  }
  tipoUser(event: any) {
    this.tipoUsuario = event.target.value;
  }
  cadastrar() {
    this.usuario.tipo = this.tipoUsuario
    if (this.usuario.senha != this.confirmarSenha) {
      alert("As senhas estão incorretas")
    }
    else {
        console.log(this.usuario);
        this.authService.cadastrar(this.usuario).subscribe((resp:UsuarioReq) =>{
          this.usuario = resp
          this.router.navigate (["/login"])
          alert("Usuario cadastrado com sucesso")
        })
    }
  }
}

