import { Component, OnInit } from '@angular/core';
import { ChercheurService } from '../services/chercheur.service';

@Component({
  selector: 'app-chercheurs',
  templateUrl: './chercheurs.component.html',
  styleUrls: ['./chercheurs.component.css']
})
export class ChercheursComponent implements OnInit {

  chercheurs: any[] = [];

  constructor(private chercheurService: ChercheurService) { }

  ngOnInit(): void {
    this.loadChercheurs(1);  // Appel de l'API pour un laboratoire spécifique (ex: labno = 1)
  }

  loadChercheurs(labno: number): void {
    this.chercheurService.getChercheursInLaboratory(labno).subscribe(
      data => {
        this.chercheurs = data;
      },
      error => {
        console.error('Error fetching chercheurs', error);
      }
    );
  }

}
