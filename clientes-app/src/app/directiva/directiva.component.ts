import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-directiva',
  templateUrl: './directiva.component.html',
  styleUrls: ['./directiva.component.css']
})
export class DirectivaComponent implements OnInit {

  public listaCursos: string[] = [ 'TypeScript', 'JavaScript', 'Java SE', 'C#', 'PHP' ];

  constructor() { }

  ngOnInit() {
  }

}
