import { ProdutoReq } from './Produto';

export class Categoria {

  public id: number;
  public ativo: boolean;
  public descicao: string;
  public palavraChave: string;
  public produto: ProdutoReq[];
}
