import { Component, OnInit } from '@angular/core';
import { StudentService } from '../../services/student-service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { StudentModel } from '../../model/student';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addstudent',
  standalone: false,
  templateUrl: './addstudent.html',
  styleUrl: './addstudent.css'
})
export class Addstudent implements OnInit {

  formGroup!: FormGroup;


  constructor(
    private studentService: StudentService,
    private formBuilder: FormBuilder,
    private router: Router

  ) { }


  ngOnInit(): void {

    this.formGroup = this.formBuilder.group({
      name: ['', Validators.required],
      age: ['', Validators.required],
      email: ['', Validators.required]
    });

  }

  onSubmit() {

    if (this.formGroup.invalid) return;

    const studentData: StudentModel = this.formGroup.value;


    this.studentService.saveStudent(studentData).subscribe({

      next: (res) => {

        console.log(res);
        this.formGroup.reset();
        this.router.navigate(['allstudent']);

      },

      error: (err) => {

        console.log(err)

      }



    });


  }



}
