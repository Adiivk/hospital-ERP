package com.example.demo.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Medication;
import com.example.demo.repository.MedicationRepository;
import com.example.demo.service.MedicationService;

@Service
public class MedicationServiceIMPL implements MedicationService{

	@Autowired
    private MedicationRepository medicationRepository;

	@Override
	public Medication addMedication(Medication medication) {
		// TODO Auto-generated method stub
		return medicationRepository.save(medication);
	}

	@Override
	public List<Medication> getAllMedication() {
		// TODO Auto-generated method stub
		return medicationRepository.findAll();
	}

	@Override
	public Medication getMedicationById(int medicationid) {
		// TODO Auto-generated method stub
		return medicationRepository.findById(medicationid).get();
	}

	@Override
	public String deleteMedicationById(int medicationid) {
		// TODO Auto-generated method stub
		Medication medication = getMedicationById(medicationid);// to check the id is present in the table or not
		medicationRepository.deleteById(medication.getMedicationId());
				return "record deleted successfully";
	}

	@Override
	public Medication updateMedicationById(int medicationid, Medication medication) {
		// TODO Auto-generated method stub
		Medication medication1 = getMedicationById(medicationid);// to check the id is present in the table or not
//		patient1.setPname(patient.getPname());
//		patient1.setPatientUsername(patient.getPatientUsername());
//		patient1.setContInfo(patient.getContInfo());
//		patient1.setInsurance_Info(patient.getInsurance_Info());
//		patient1.setPatientPassword(patient.getPatientPassword());
		return medicationRepository.save(medication1);
	}
	
	
}