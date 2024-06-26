package Dao;
import Entity.Artist;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import Repository.ArtistRepository;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class ArtistDaoImpl implements  ArtistDao{
    final ArtistRepository artistRepository;

    @Override
    public Integer getArtistSize() {
        return Math.toIntExact(artistRepository.count());
    }

    @Override
    public Page<Artist> getArtists(Integer pageSize, Integer page) {
        long totalEvents = artistRepository.count();
        pageSize = pageSize == null ? (int) totalEvents : pageSize;
        page = page == null ? 0 : page - 1;
        return artistRepository.findAll(PageRequest.of(page, pageSize));
    }

    @Override
    public Artist getArtistById(Long id) {
        return artistRepository.findById(id).orElse(null);
    }

    @Override
    public Artist save(Artist artist) {
        return artistRepository.save(artist);
    }

    @Override
    public Optional<Artist> findById(Long id) {
        return artistRepository.findById(id);
    }

    @Override
    public Page<Artist> getArtist(String name, Pageable page) {
        return artistRepository.findByNameContainingIgnoreCaseOrArtistID(name, name, page);
    }
}
