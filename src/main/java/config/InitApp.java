package config;

import Entity.Admin;
import Entity.Artist;
import Repository.ArtistRepository;
import Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final CustomerRepository customerRepository;
    final ArtistRepository artistRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {

        Admin admin;

        admin = adminRepository.save(Admin.builder()

                .username("Admin1")
                .password("Admin12345")
                .name("Suchanun")
                .surname("Sirijanya")
                .signname("SiriJ")
                .image("[https://live.staticflickr.com/65535/53282674660_836c2d9995_o.jpg")
                .build());

        Artist artist;

        artist = artistRepository.save(Artist.builder()

                .username("Artist1")
                .password("Artist1")
                .name("Keishin")
                .surname("Ukai")
                .signname("Ukaii")
                .image("https://live.staticflickr.com/65535/53133761344_316fb142a6_o.png")
                .Portforiolink("https://docs.google.com/document/d/1XZfEj-0Fs4vrgX_Qmgr1gKll-pIw6dnLvh5pyPF9v48/edit")
                .Bankaccount("BBL")
                .Banknum("0000000000")
                .BankName("Keishin Ukai")
                .build());


        artistRepository.save(Artist.builder()

                .username("Artist2")
                .password("Artist")
                .name("Yasufumi")
                .surname("Neko.")
                .signname("Yasuneko")
                .image("https://live.staticflickr.com/65535/53133764254_86716f4c97_z.jpg")
                .Portforiolink("https://docs.google.com/document/d/1XZfEj-0Fs4vrgX_Qmgr1gKll-pIw6dnLvh5pyPF9v48/edit")
                .Bankaccount("BBL")
                .Banknum("0000000000")
                .BankName("Keishin Ukai")
                .build());


        Customer customer;
        Customer = customerRepository.save(User.builder()

                .username("Customer1")
                .password("Customer1")
                .name("Shoyo")
                .surname("Hinata")
                .signname("Hina")
                .image("https://live.staticflickr.com/65535/53133553491_793e26edb5_o.png")
                .Portforiolink("https://docs.google.com/document/d/1XZfEj-0Fs4vrgX_Qmgr1gKll-pIw6dnLvh5pyPF9v48/edit")
                .Bankaccount("KKP")
                .Banknum("1111111111")
                .BankName("Shoyo Hinata"));

        customerRepository.save(Customer.builder()

                .username("Customer1")
                .password("Customer1")
                .name("Kuroo")
                .surname("Tetsuro")
                .signname("Kuro")
                .image("https://live.staticflickr.com/65535/53132961792_5b6bede0a8_o.png")
                .Portforiolink("https://docs.google.com/document/d/1XZfEj-0Fs4vrgX_Qmgr1gKll-pIw6dnLvh5pyPF9v48/edit")
                .Bankaccount("KKP")
                .Banknum("2222222222")
                .BankName("Tetsuro Kuroo"));
    }
}