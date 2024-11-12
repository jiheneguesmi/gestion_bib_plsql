import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ChercheurService {

  private apiUrl = 'http://localhost:8085/api/chercheurs'; // URL de ton API backend

  constructor(private http: HttpClient) { }

  getPublicationsByChercheur(chno: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/${chno}/publications`);
  }

  getChercheursInLaboratory(labno: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/laboratoire/${labno}/chercheurs`);
  }

}
