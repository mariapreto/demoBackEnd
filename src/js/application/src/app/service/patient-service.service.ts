import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Patient } from '../model/patient';
import { Observable, of } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  private patientsUrl: string;

  constructor(private http: HttpClient) {
    this.patientsUrl = 'http://localhost:8080/patients';
   }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

   public findAll():  Observable<Patient[]> {
    return this.http.get<Patient[]>(this.patientsUrl);
  }

   /** Get Patient by id. Will 404 if not found */
  public getPatient(id: number): Observable<Patient> {
    const url = `${this.patientsUrl}/${id}`;
    return this.http.get<Patient>(url).pipe(
      catchError(this.handleError<Patient>(`getPatient id=${id}`))
    );
  }

    /** Get Patients whose name contais search terms */
    searchPatients(term: string): Observable<Patient[]> {
      if(!term.trim()){
        // if not search term, return empty patient array.
        return of([]);
      }
      return this.http.get<Patient[]>(`${this.patientsUrl}/?name=${term}`).pipe(
        catchError(this.handleError<Patient[]>('searchPatient', []))
      );
    }

   public save(patient: Patient) {
     return this.http.post<Patient>(this.patientsUrl, patient);
   }
  
  deletePatient(patient: Patient): Observable<Patient> {
    const url = `${this.patientsUrl}/delete/${patient.id}`;
    return this.http.post<Patient>(url, patient, this.httpOptions);
  }

    /**
    * Handle Http operation that failed.
    * Let the app continue.
    * @param operation - name of the operation that failed
    * @param result - optional value to return as the observable result
    */
    private handleError<T> (operation = 'operation', result?: T) {
      return (error: any): Observable<T> => {
  
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead
  
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
