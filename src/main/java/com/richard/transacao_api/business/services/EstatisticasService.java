package com.richard.transacao_api.business.services;

import com.richard.transacao_api.controller.dtos.EstatisticasResponseDTO;
import com.richard.transacao_api.controller.dtos.TransacaoRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EstatisticasService {

    public final TransacaoService transacaoService;

    public EstatisticasResponseDTO calcularEstatiscasTransacoes(Integer intervaloBusca) {

        //System.out.println("Iniciada busca de estatísticas de transações pelo periodo de tempo " + intervaloBusca);
        log.info("Iniciada busca de estatísticas de transações pelo periodo de tempo " + intervaloBusca);

        List<TransacaoRequestDTO> transacoes = transacaoService.buscarTransacoes(intervaloBusca);


        if(transacoes.isEmpty()){
            return new EstatisticasResponseDTO(0L, 0.0, 0.0, 0.0, 0.0);

        }

        DoubleSummaryStatistics estatisticasTransacoes = transacoes.stream()
                .mapToDouble(TransacaoRequestDTO::valor).summaryStatistics();

        //System.out.println("Estatísticas retornadas com sucesso");
        log.info("Estatísticas retornadas com sucesso");
        return new EstatisticasResponseDTO(estatisticasTransacoes.getCount(),
                estatisticasTransacoes.getSum(),
                estatisticasTransacoes.getAverage(),
                estatisticasTransacoes.getMin(),
                estatisticasTransacoes.getMax());
    }
}
