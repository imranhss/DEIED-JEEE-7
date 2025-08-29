import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { StudentModel } from '../../model/student';
import { StudentService } from '../../services/student-service';

@Component({
  selector: 'app-allstudent',
  standalone: false,
  templateUrl: './allstudent.html',
  styleUrl: './allstudent.css'
})
export class Allstudent implements OnInit {


  students: any;

  ngOnInit(): void {
    this.getAllStudent();
  }


  constructor(
    private studentService: StudentService,
    private cd: ChangeDetectorRef

  ) { }


  getAllStudent() {


    this.studentService.getAllStudent().subscribe({
      next: (data) => {

        this.students = data;
        this.cd.markForCheck();

        console.log(this.students);

      },


      error: err => {

        console.log(err);
      }


    });

  }




}
