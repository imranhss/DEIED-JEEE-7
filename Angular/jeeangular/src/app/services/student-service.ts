
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { StudentModel } from '../model/student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {


apiUrl: string = "http://localhost:8080/api/student";


constructor(
private  http: HttpClient
){}


getAllStudent(): Observable<StudentModel>{

  return this.http.get<StudentModel>(this.apiUrl);

}

saveStudent(student : StudentModel){

  return this.http.post(this.apiUrl, student);

}


  
}
