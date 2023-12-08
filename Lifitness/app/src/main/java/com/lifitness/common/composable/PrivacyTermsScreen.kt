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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.lifitness.R

@Composable
fun PrivacyTermsScreen() {
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
                text = "Termos de Privacidade - Lifitness",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("SEÇÃO 1 - INFORMAÇÕES GERAIS\n\n")
                    }
                    append(
                        "Os dados pessoais do usuário e visitante são recolhidos pela plataforma da seguinte forma:\n\nA presente Política de Privacidade contém informações sobre coleta, uso, armazenamento, tratamento e proteção dos dados pessoais dos usuários e visitantes do aplicativo Lifitness, com a finalidade de demonstrar absoluta transparência quanto ao assunto e esclarecer a todos interessados sobre os tipos de dados que são coletados, os motivos da coleta e a forma como os usuários podem gerenciar ou excluir as suas informações pessoais.\n" +
                                "\n" +
                                "Esta Política de Privacidade aplica-se a todos os usuários e visitantes do aplicativo Lifitness e integra os Termos e Condições Gerais de Uso do aplicativo Lifitness."
                    )
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("SEÇÃO 3 - COMO RECOLHEMOS OS DADOS PESSOAIS DO USUÁRIO E DO VISITANTE?\n\n")
                    }
                    append(
                        "Quando o usuário cria uma conta/perfil na plataforma Lifitness: esses dados são os dados de identificação básicos como: email, nome de usuário e profissão. A partir deles, podemos identificar o usuário e o visitante, além de garantir uma maior segurança e bem-estar às suas necessidade. Ficam cientes os usuários e visitantes de que seu perfil na plataforma estará acessível a todos demais usuários e visitantes da plataforma Lifitness."

                    )
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("SEÇÃO 3 - QUAIS DADOS PESSOAIS RECOLHEMOS SOBRE O USUÁRIO E VISITANTE?\n\n")
                    }
                    append(

                            "Os dados pessoais do usuário e visitante recolhidos são os seguintes:\n\nDados para a criação da conta/perfil na plataforma Lifitness: e-mail, nome de usuário, idade, autura, peso, nível de atividade física diária estimado, objetivos de mudança corporal e impedimentos da vida rotineira, quanto a prática de atividades físicas casa haja(m) algum(ns)."
                    )
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("SEÇÃO 3 - PARA QUE FINALIDADES UTILIZAMOS OS DADOS PESSOAIS DO USUÁRIO E VISITANTE?\n\n")
                    }
                    append(
                        "Os dados pessoais do usuário e do visitante coletados e armazenados pela plataforma Lifitness tem por finalidade:\n" +
                                "\n" +
                                "Bem-estar do usuário e visitante: aprimorar o produto e/ou serviço oferecido, facilitar, agilizar e cumprir os compromissos estabelecidos entre o usuário e a empresa, melhorar a experiência dos usuários e fornecer funcionalidades específicas a depender das características básicas do usuário.\n" +
                                "\n" +
                                "Melhorias da plataforma: compreender como o usuário utiliza os serviços da plataforma, para ajudar no desenvolvimento de negócios e técnicas.\n" +
                                "\n" +
                                "Anúncios: apresentar anúncios personalizados para o usuário com base nos dados fornecidos.\n" +
                                "\n" +
                                "Comercial: os dados são usados para personalizar o conteúdo oferecido e gerar subsídio à plataforma para a melhora da qualidade no funcionamento dos serviços.\n" +
                                "\n" +
                                "Previsão do perfil do usuário: tratamento automatizados de dados pessoais para avaliar o uso na plataforma.\n" +
                                "\n" +
                                "Dados de cadastro: para permitir o acesso do usuário a determinados conteúdos da plataforma, exclusivo para usuários cadastrados"
                    )
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("SEÇÃO 4 - POR QUANTO TEMPO OS DADOS PESSOAIS FICAM ARMAZENADOS?\n\n")
                    }
                    append(
                        "Os dados pessoais do usuário e visitante são armazenados pela plataforma durante o período necessário para a prestação do serviço ou o cumprimento das finalidades previstas no presente documento, conforme o disposto no inciso I do artigo 15 da Lei 13.709/18.\n" +
                                "\n" +
                                "Os dados podem ser removidos ou anonimizados a pedido do usuário, excetuando os casos em que a lei oferecer outro tratamento.\n" +
                                "\n" +
                                "Ainda, os dados pessoais dos usuários apenas podem ser conservados após o término de seu tratamento nas seguintes hipóteses previstas no artigo 16 da referida lei:\n" +
                                "\n" +
                                "I - cumprimento de obrigação legal ou regulatória pelo controlador;\n" +
                                "\n" +
                                "II - estudo por órgão de pesquisa, garantida, sempre que possível, a anonimização dos dados pessoais;\n" +
                                "\n" +
                                "III - transferência a terceiro, desde que respeitados os requisitos de tratamento de dados dispostos nesta Lei;\n" +
                                "\n" +
                                "IV - uso exclusivo do controlador, vedado seu acesso por terceiro, e desde que anonimizados os dados."
                    )
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("SEÇÃO 5 - SEGURANÇA DOS DADOS PESSOAIS ARMAZENADOS\n\n")
                    }
                    append(
                        "A plataforma se compromete a aplicar as medidas técnicas e organizativas aptas a proteger os dados pessoais de acessos não autorizados e de situações de destruição, perda, alteração, comunicação ou difusão de tais dados.\n" +
                                "\n" +
                                "Os dados relativas a cartões de crédito são criptografados usando a tecnologia \"secure socket layer\" (SSL) que garante a transmissão de dados de forma segura e confidencial, de modo que a transmissão dos dados entre o servidor e o usuário ocorre de maneira cifrada e encriptada.\n" +
                                "\n" +
                                "A plataforma não se exime de responsabilidade por culpa exclusiva de terceiro, como em caso de ataque de hackers ou crackers, ou culpa exclusiva do usuário, como no caso em que ele mesmo transfere seus dados a terceiros. O site se compromete a comunicar o usuário em caso de alguma violação de segurança dos seus dados pessoais.\n" +
                                "\n" +
                                "Os dados pessoais armazenados são tratados com confidencialidade, dentro dos limites legais. No entanto, podemos divulgar suas informações pessoais caso sejamos obrigados pela lei para fazê-lo ou se você violar nossos Termos de Serviço."
                    )
                },
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

    }
}