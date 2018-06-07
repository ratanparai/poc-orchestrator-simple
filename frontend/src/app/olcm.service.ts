import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError, map, tap} from 'rxjs/operators';

import { Olcm } from './olcm';

const httpOptions = {
  headers: new HttpHeaders( { 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class OlcmService {

  readonly orchestratorUrl = 'http://localhost:5101';

  constructor(private http: HttpClient) { }

  getOlcms(): Observable<Olcm[]> {
    return this.http.get<Olcm>(this.orchestratorUrl)
      .pipe(
        tap( olcms => console.log("fetched olcms")),
        catchError(this.handleError(`getOlcms`))
      ) as Observable<Olcm[]>;
  }


  /**
   * Returns a function that handles Http operation failures.
   * This error handler lets the app continue to run as if no error occurred.
   * @param operation - name of the operation that failed
   */
  private handleError<T>(operation = 'operation') {
    return (error: HttpErrorResponse): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead
      const message = (error.error instanceof ErrorEvent) ?
        error.error.message :
        `server returned code ${error.status} with body "${error.error}"`;

      // TODO: better job of transforming error for user consumption
      throw new Error(`${operation} failed: ${message}`);
    };

  }

}
