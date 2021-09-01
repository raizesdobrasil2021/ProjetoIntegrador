
import { UsuarioReq } from './Usuario';
import { CategoriaReq } from './Categoria';
export class ProdutoReq {

    public id: number;
    public nome: string;
    public preco: number;
    public quantidade: number;
    public usuario: UsuarioReq;
    public categoria: CategoriaReq;
}
