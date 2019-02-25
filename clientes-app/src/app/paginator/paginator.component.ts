import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-paginator',
  templateUrl: './paginator.component.html',
  styleUrls: ['./paginator.component.css']
})
export class PaginatorComponent implements OnInit {
  
  @Input()
  public paginator: any;
  public paginas: number[];

  constructor() { }

  ngOnInit() {
    this.paginas = Array(this.paginator.totalPages).fill(0).map((valor, indice) => indice + 1);
  }

}
