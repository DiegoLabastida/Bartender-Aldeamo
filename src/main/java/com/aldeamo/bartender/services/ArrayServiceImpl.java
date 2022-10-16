package com.aldeamo.bartender.services;

import com.aldeamo.bartender.models.entity.Array;
import com.aldeamo.bartender.models.repository.ArrayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class ArrayServiceImpl implements ArrayService{

    @Autowired
    private ArrayRepository arrayRepository;

    @Override
    @Transactional(readOnly = true)
    public String pruebaAldeamo(int Q, Long id) {
        int[] P = {2, 3, 5, 7, 11, 13, 17};
        int[] response = {};

        Optional<Array> opt = arrayRepository.findById(id);
        if ( opt.isEmpty() ) return "Id " + id + " no existe";

        String[] string_A = opt.get().getInputArray().split(",");
        int[] A = Stream.of(string_A).mapToInt(Integer::parseInt).toArray();

        for( int i=0; i<Q; i++ ){
            int Pi = P[i];
            int[] Ai = new int[A.length], B = new int[A.length];

            int ind_A = 0, ind_B = 0;
            for(int a : A) {
                if ( a%Pi == 0) {
                    B[ind_B] = a;
                    ind_B++;
                } else {
                    Ai[ind_A] = a;
                    ind_A++;
                }
            }
            B = Arrays.stream(B)
                    .filter(j -> j != 0)
                    .toArray();
            Ai = Arrays.stream(Ai)
                    .filter(j -> j != 0)
                    .toArray();
            A = Ai;
            response = IntStream.concat(Arrays.stream(response), Arrays.stream(B))
                    .toArray();
        }
        response = IntStream.concat(Arrays.stream(response), Arrays.stream(A))
                .toArray();

        return "Respuesta = " + Arrays.toString(response).replace("[/[/]]", "");
    }
}
