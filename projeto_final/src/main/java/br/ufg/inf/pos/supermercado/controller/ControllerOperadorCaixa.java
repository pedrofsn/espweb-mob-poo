package br.ufg.inf.pos.supermercado.controller;

import br.ufg.inf.pos.supermercado.exception.ValidacaoException;
import br.ufg.inf.pos.supermercado.model.Caixa;
import br.ufg.inf.pos.supermercado.model.Funcionario;
import br.ufg.inf.pos.supermercado.util.Constantes;
import br.ufg.inf.pos.supermercado.util.Utils;

import java.util.List;

/**
 * Created by pedrofsn on 20/05/2017.
 */
public class ControllerOperadorCaixa {

    public void assumirCaixa(List<Funcionario> funcionarios, List<Caixa> caixas, Integer f, Integer c) throws ValidacaoException {
        if (!Utils.isNullOrEmpty(funcionarios) && !Utils.isNullOrEmpty(caixas) && !Utils.isNullOrEmpty(f) && !Utils.isNullOrEmpty(c)) {

            if (!(f > Constantes.VALOR_INVALIDO && f <= funcionarios.size() - 1)) {
                throw new ValidacaoException("O código do funcionário é inválido");
            }

            if (!(c > Constantes.VALOR_INVALIDO && c <= caixas.size() - 1)) {
                throw new ValidacaoException("O código do caixa é inválido");
            }

            // Remover casos existens
            for (Funcionario funcionario : funcionarios) {
                if (funcionario.getCodigoCaixa() == c) {
                    funcionario.setCodigoCaixa(null);
                }
            }

            for (Caixa caixa : caixas) {
                if (caixa.getCodigoFuncionario() == f) {
                    caixa.setCodigoFuncionario(null);
                }
            }

            // Setar novo caso
            for (Funcionario funcionario : funcionarios) {
                if (funcionario.getCodigo() == f) {
                    funcionario.setCodigoCaixa(c);
                }
            }

            for (Caixa caixa : caixas) {
                if (caixa.getCodigo() == c) {
                    caixa.setCodigoFuncionario(f);
                }
            }
        }
    }
}
