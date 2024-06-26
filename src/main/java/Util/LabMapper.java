package Util;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import Dto.OwnCustomerDto;
import Dto.OwnArtistDto;
import Dto.CustomerDto;
import Dto.ArtistDto;
import Entity.Artist;
import Entity.Customer;

import java.beans.Customizer;
import java.util.List;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
    CustomerDto getCustomerDto(User user);
    List<CustomerDto> getCustomerDto(List<User> users);
    ArtistDto getArtistDto(Artist artist);
    List<ArtistDto> getArtistDto(List<Artist> advisors);
    OwnArtistDto getAdvisor(Artist artist);
    OwnCustomerDto getAdvisee(User user);

}