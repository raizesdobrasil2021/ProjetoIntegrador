import { ProdutoReq } from './ProdutoReq';

export class CategoriaReq {

  public id: number;
  public ativo: boolean;
  public descicao: string;
  public palavraChave: string;
  public produto: ProdutoReq[];
}
