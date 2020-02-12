import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Patient } from '../model/patient';
import { PatientService } from '../service/patient-service.service';

@Component({
  selector: 'app-patient-form',
  templateUrl: './patient-form.component.html',
  styleUrls: ['./patient-form.component.css']
})
export class PatientFormComponent implements OnInit {

  patient: Patient;

  constructor(
    private route: ActivatedRoute, 
    private router: Router, 
      private patientService: PatientService) {
        this.patient = new Patient();
       }

  ngOnInit() {
  }

  onSubmit() {
    this.patientService.save(this.patient).subscribe(result => this.gotoPatientList());
  }
 
  gotoPatientList() {
    this.router.navigate(['/patients']);
  }

}
