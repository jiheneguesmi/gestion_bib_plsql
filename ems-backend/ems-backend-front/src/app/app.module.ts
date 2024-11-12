import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';

// Déclarer seulement les composants non autonomes ici
import { ChercheursComponent } from './chercheurs/chercheurs.component';

@NgModule({
  declarations: [
    ChercheursComponent, // Seulement les composants non autonomes
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes), // Charger vos routes si nécessaire
  ],
  providers: [],
  bootstrap: [] // Ne mettez rien ici pour un projet avec composants autonomes
})
export class AppModule { }
