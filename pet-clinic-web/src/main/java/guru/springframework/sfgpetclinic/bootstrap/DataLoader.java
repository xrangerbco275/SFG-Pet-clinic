package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner
{
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService)
    {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception
    {
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