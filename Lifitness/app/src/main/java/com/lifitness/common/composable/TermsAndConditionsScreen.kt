package com.lifitness.common.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lifitness.R

@Composable
fun TermsAndConditionsScreen() {
    Surface(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = R.color.screen_background_color))
        .padding(16.dp)) {

        //HeadingTextComponent(value = stringResource(id = R.string.terms_and_conditions_header))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())

        ) {
            Text(
                text = "Termos de Uso - Lifitness",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("1. Do objeto\n\n")
                    }
                    append(
                        "A plataforma visa licenciar o uso de seu software, website, aplicativos e demais ativos de propriedade intelectual, fornecendo ferramentas para auxiliar e dinamizar o dia a dia dos seus usuários.\n" +
                                "\n" +
                                "A plataforma caracteriza-se pela prestação do seguinte serviço: assistênica no gerenciamento de treinamento físico.\n" +
                                "\n"
                    )
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("2. Da aceitação\n\n")
                    }
                    append(
                        "O presente Termo estabelece obrigações contratadas de livre e espontânea vontade, por tempo indeterminado, entre a plataforma e as pessoas físicas ou jurídicas, usuárias do aplicativo.\n" +
                                "\n" +
                                "Ao utilizar a plataforma o usuário aceita integralmente as presentes normas e compromete-se a observá-las, sob o risco de aplicação das penalidade cabíveis.\n" +
                                "\n" +
                                "A aceitação do presente instrumento é imprescindível para o acesso e para a utilização de quaisquer serviços fornecidos pela empresa. Caso não concorde com as disposições deste instrumento, o usuário não deve utilizá-los..\n\n"
                    )
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("3. Do acesso dos usuários\n\n")
                    }
                    append(
                        "Serão utilizadas todas as soluções técnicas à disposição do responsável pela plataforma para permitir o acesso ao serviço 24 (vinte e quatro) horas por dia, 7 (sete) dias por semana. No entanto, a navegação na plataforma ou em alguma de suas páginas poderá ser interrompida, limitada ou suspensa para atualizações, modificações ou qualquer ação necessária ao seu bom funcionamento.\n\n"
                    )
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("4. Do cadastro\n\n")
                    }
                    append(
                        "O acesso às funcionalidades da plataforma exigirá a realização de um cadastro prévio e, a depender dos serviços ou produtos escolhidos, o pagamento de determinado valor.\n" +
                                "\n" +
                                "Ao se cadastrar o usuário deverá informar dados completos, recentes e válidos, sendo de sua exclusiva responsabilidade manter referidos dados atualizados, bem como o usuário se compromete com a veracidade dos dados fornecidos.\n" +
                                "\n" +
                                "O usuário se compromete a não informar seus dados cadastrais e/ou de acesso à plataforma a terceiros, responsabilizando-se integralmente pelo uso que deles seja feito.\n" +
                                "\n" +
                                "Menores de 18 anos e aqueles que não possuírem plena capacidade civil deverão obter previamente o consentimento expresso de seus responsáveis legais para utilização da plataforma e dos serviços ou produtos, sendo de responsabilidade exclusiva dos mesmos o eventual acesso por menores de idade e por aqueles que não possuem plena capacidade civil sem a prévia autorização.\n" +
                                "\n" +
                                "Mediante a realização do cadastro o usuário declara e garante expressamente ser plenamente capaz, podendo exercer e usufruir livremente dos serviços e produtos.\n" +
                                "\n" +
                                "O usuário deverá fornecer um endereço de e-mail válido, através do qual o site realizará todas comunicações necessárias.\n" +
                                "\n" +
                                "Após a confirmação do cadastro, o usuário possuirá um login e uma senha pessoal, a qual assegura ao usuário o acesso individual à mesma. Desta forma, compete ao usuário exclusivamente a manutenção de referida senha de maneira confidencial e segura, evitando o acesso indevido às informações pessoais.\n" +
                                "\n" +
                                "Toda e qualquer atividade realizada com o uso da senha será de responsabilidade do usuário, que deverá informar prontamente a plataforma em caso de uso indevido da respectiva senha.\n" +
                                "\n" +
                                "Não será permitido ceder, vender, alugar ou transferir, de qualquer forma, a conta, que é pessoal e intransferível.\n" +
                                "\n" +
                                "Caberá ao usuário assegurar que o seu equipamento seja compatível com as características técnicas que viabilize a utilização da plataforma e dos serviços ou produtos.\n" +
                                "\n" +
                                "O usuário poderá, a qualquer tempo, requerer o cancelamento de seu cadastro junto ao aplicativo Lifitness. O seu descadastramento será realizado o mais rapidamente possível, desde que não sejam verificados débitos em aberto.\n" +
                                "\n" +
                                "O usuário, ao aceitar os Termos e Política de Privacidade, autoriza expressamente a plataforma a coletar, usar, armazenar, tratar, ceder ou utilizar as informações derivadas do uso dos serviços, do site e quaisquer plataformas, incluindo todas as informações preenchidas pelo usuário no momento em que realizar ou atualizar seu cadastro, além de outras expressamente descritas na Política de Privacidade que deverá ser autorizada pelo usuário.\n\n"
                    )
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("5. Das responsabilidades\n\n")
                    }
                    append(
                        "É de responsabilidade do usuário:\n" +
                                "\n" +
                                "a) defeitos ou vícios técnicos originados no próprio sistema do usuário;\n" +
                                "\n" +
                                "b) a correta utilização da plataforma, dos serviços ou produtos oferecidos, prezando pela boa convivência, pelo respeito e cordialidade entre os usuários;\n" +
                                "\n" +
                                "c) pelo cumprimento e respeito ao conjunto de regras disposto nesse Termo de Condições Geral de Uso, na respectiva Política de Privacidade e na legislação nacional e internacional;\n" +
                                "\n" +
                                "d) pela proteção aos dados de acesso à sua conta/perfil (login e senha).\n" +
                                "\n" +
                                "\n" +
                                "É de responsabilidade da plataforma Liftiness:\n" +
                                "\n" +
                                "a) indicar as características do serviço ou produto;\n" +
                                "\n" +
                                "b) os defeitos e vícios encontrados no serviço ou produto oferecido desde que lhe tenha dado causa;\n" +
                                "\n" +
                                "c) as informações que foram por ele divulgadas, sendo que os comentários ou informações divulgadas por usuários são de inteira responsabilidade dos próprios usuários;\n" +
                                "\n" +
                                "d) os conteúdos ou atividades ilícitas praticadas através da sua plataforma.\n" +
                                "\n" +
                                "\n" +
                                "A plataforma não se responsabiliza por links externos contidos em seu sistema que possam redirecionar o usuário à ambiente externo a sua rede.\n" +
                                "\n" +
                                "Não poderão ser incluídos links externos ou páginas que sirvam para fins comerciais ou publicitários ou quaisquer informações ilícitas, violentas, polêmicas, pornográficas, xenofóbicas, discriminatórias ou ofensivas.\n\n"
                    )
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("6. Das sanções\n\n")
                    }
                    append(
                        "Sem prejuízo das demais medidas legais cabíveis, a razão social __ poderá, a qualquer momento, advertir, suspender ou cancelar a conta do usuário:\n" +
                                "\n" +
                                "a) que violar qualquer dispositivo do presente Termo;\n" +
                                "\n" +
                                "b) que descumprir os seus deveres de usuário;\n" +
                                "\n" +
                                "c) que tiver qualquer comportamento fraudulento, doloso ou que ofenda a terceiros.\n"
                    )
                },
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

    }
}

@Preview
@Composable
fun TermsAndConditionsScreenPreview(){
    TermsAndConditionsScreen()
}