package com.example.demo.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Appointment;
import com.example.demo.model.Doctor;
import com.example.demo.model.Patient;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.service.AppointmentService;
import com.example.demo.service.DoctorService;
import com.example.demo.service.PatientService;

@Service
public class AppointmentServiceIMPL implements AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private PatientService patientService;

	@Override
	public Appointment addAppointment(Appointment appointment, int doctorId, int patientId) {
		// TODO Auto-generated method stud
		Doctor doctor = doctorService.getDoctorById(doctorId);
		Patient patient = patientService.getPatientById(patientId);
		appointment.setDoctor(doctor);
		appointment.setPatient(patient);
		return appointmentRepository.save(appointment);
	}

	@Override
	public List<Appointment> getAllAppointment() {
		// TODO Auto-generated method stub
		return appointmentRepository.findAll();
	}

	@Override
	public Appointment getAppointmentById(int appointmentid) {
		// TODO Auto-generated method stub
		return appointmentRepository.findById(appointmentid).get();
	}

	@Override
	public String deleteAppointmentById(int appointmentid) {
		// TODO Auto-generated method stub
		Appointment appointment = getAppointmentById(appointmentid);// to check the id is present in the table or not
		appointmentRepository.deleteById(appointment.getAppId());
		return "record deleted successfully";
	}

	@Override
	public Appointment updateAppointmentById(int appointmentid, Appointment appointment) {
		// TODO Auto-generated method stub
		Appointment appointment1 = getAppointmentById(appointmentid);// to check the id is present in the table or not
//		patient1.setPname(patient.getPname());
//		patient1.setPatientUsername(patient.getPatientUsername());
//		patient1.setContInfo(patient.getContInfo());
//		patient1.setInsurance_Info(patient.getInsurance_Info());
//		patient1.setPatientPassword(patient.getPatientPassword());
		return appointmentRepository.save(appointment1);
	}

}
