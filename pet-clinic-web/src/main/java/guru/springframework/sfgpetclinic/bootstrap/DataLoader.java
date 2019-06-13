package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner
{
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService)
    {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception
    {

        PetType dog = new PetType();
        dog.setName("Dobberman");
        PetType savedDogPetTYpe = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Siamiese");
        PetType savedCatPetTYpe = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Joe");
        owner1.setLastName("Cruz");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Bob");
        owner2.setLastName("Denver");
        ownerService.save(owner2);

        System.out.println("Loaded Owners ...");
        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Adams");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sam");
        vet2.setLastName("Smith");

        vetService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setFirstName("Bob");
        vet3.setLastName("Dole");

        vetService.save(vet3);

        System.out.println("Loading Vets...");
    }
}
