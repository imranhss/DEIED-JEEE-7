import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Allstudent } from './allstudent';

describe('Allstudent', () => {
  let component: Allstudent;
  let fixture: ComponentFixture<Allstudent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [Allstudent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Allstudent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
