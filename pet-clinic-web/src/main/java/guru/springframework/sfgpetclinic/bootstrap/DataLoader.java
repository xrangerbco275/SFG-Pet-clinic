package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner
{
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialtyService specialtyService)
    {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception
    {
        int count = petTypeService.findAll().size();
        if (count == 0) {loadData();}
    }

    private void loadData()
    {
        Speciality radiology = new Speciality();
        radiology.setDescription("Radioology");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialtyService.save(dentistry);


        PetType dog = new PetType();
        dog.setName("Dobberman");
        PetType savedDogPetTYpe = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Siamiese");
        PetType savedCatPetTYpe = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Mike");
        owner1.setLastName("Smith");
        Address address = new Address();
        address.setAddress("12345 State St");
        address.setCity("St Louis");
        address.setState("MO");
        address.setZip("63104");
        address.setTelephone("3144207996");
        owner1.setAddress(address);

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetTYpe);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Bear");
        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Bob");
        owner2.setLastName("Denver");
        address = new Address();
        address.setAddress("7654 Main  St");
        address.setCity("St Louis");
        address.setState("MO");
        address.setZip("63323");
        address.setTelephone("3145556789");
        owner2.setAddress(address);

        Pet bobsPet = new Pet();
        bobsPet.setPetType(savedCatPetTYpe);
        bobsPet.setOwner(owner2);
        bobsPet.setBirthDate(LocalDate.now());
        bobsPet.setName("Mia");
        owner1.getPets().add(bobsPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners ...");
        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Adams");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sam");
        vet2.setLastName("Smith");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setFirstName("Bob");
        vet3.setLastName("Dole");
        vet3.getSpecialities().add(savedDentistry);
        vetService.save(vet3);

        System.out.println("Loading Vets...");
    }
}
