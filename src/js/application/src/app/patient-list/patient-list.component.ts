import { Component, OnInit } from '@angular/core';
import { Patient } from '../model/patient';
import { PatientService } from '../service/patient-service.service';

@Component({
  selector: 'app-patient-list',
  templateUrl: './patient-list.component.html',
  styleUrls: ['./patient-list.component.css']
})
export class PatientListComponent implements OnInit {

  patients: Patient[];

  constructor(private patientService: PatientService) { }

  ngOnInit() {
    this.patientService.findAll().subscribe(data => {
      this.patients = data;
    });
  }

  delete(patient: Patient): void {
    this.patients = this.patients.filter(h => h !== patient);
    this.patientService.deletePatient(patient.id).subscribe();
  }
}
