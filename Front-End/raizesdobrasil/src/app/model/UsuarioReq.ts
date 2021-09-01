        
import { ProdutoReq } from './ProdutoReq';

export class UsuarioReq {

    public id: number;
    public nome: string;
    public senha: string;
    public tipo: string;
    public dataNascimento: Date;
    public usuario: string;
    public email: string;
    public produto: ProdutoReq[];
}
