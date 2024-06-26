package Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import Entity.Artist;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    List<Artist> findAll();

   Page<Artist> findByNameContainingIgnoreCaseOrArtistID(String name, String ArtistID, Pageable page);
}