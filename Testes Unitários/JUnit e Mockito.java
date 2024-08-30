package br.com.alura.adopet.api.validacoes;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.repository.PetRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

// Com o Mockito os testes ja ficam interessantes
// Consigo utilizar a anotação @Mock para instanciar um `dublê` para ser utilizado
// Com isso preciso falar que essa classe pode ser injetada pelos mocks, com a anotação @InjectMocks
// Como os Mocks são apenas dublês, precisamos dizer a eles o que precisam fazer, como devem agir e o que devem retornar.
// exemplo: .willReturn(pet), estou dizendo para o duble retornar uma instância de pet que também é dublê 
// também acesso o metodo do pet e digo que ele precisa me retornar true ou false, dependendo do resultado que eu quiser testar

// Utilizado metodos do JUnit para testar um metodo void, assertThrows(tipoException, deOndeVemAException) e assertDoesNotThrow(deOndeVemAException)

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ValidacaoPetDisponivelTest {

    @InjectMocks
    private ValidacaoPetDisponivel validacao;
    @Mock
    private PetRepository petRepository;

    @Mock
    private Pet pet;
    @Mock
    private SolicitacaoAdocaoDto dto;

    @Test
    void deveriaPermitirSolicitacaoDeAdocaoPet(){

        //ARRANGE
        BDDMockito.given(petRepository.getReferenceById(dto.idPet())).willReturn(pet);
        BDDMockito.given(pet.getAdotado()).willReturn(false);



        //ASSERT + ACT
        Assertions.assertDoesNotThrow(() -> validacao.validar(dto));
    }

    @Test
    void naoDeveriaPermitirSolicitacaoDeAdocaoPet(){

        //ARRANGE
        BDDMockito.given(petRepository.getReferenceById(dto.idPet())).willReturn(pet);
        BDDMockito.given(pet.getAdotado()).willReturn(true);



        //ASSERT + ACT
        Assertions.assertThrows(ValidacaoException.class,() -> validacao.validar(dto));
    }

}
