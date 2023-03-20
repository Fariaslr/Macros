create database macros;

use macros;

create table endereco(
    codigoEndereco int auto_increment primary key,
    logradouro varchar(50),
    complemento varchar(50),
    numero int,
    bairro varchar(30),
    cidade varchar(30),
    estado varchar(30),
    cep char(8)
    );

create table paciente(
	cpf char(11) primary key,
    nomePaciente varchar(25),
    sobrenomePaciente varchar(50),
    telefone char(11),
    email varchar(25),
    dataNascimento date,
    sexo char(1),
    codigoEndereco int
    );
    
alter table paciente
add constraint fkPacienteEndereco foreign key(codigoEndereco) references endereco(codigoEndereco);
    
create table nutricionista(
	cpfNutricionista char(11) primary key,
    registroNutricionista char(5),
    nomeNutricionista varchar (20),
    sobrenomeNutricionista varchar (50),
    dataNascimento date,
    sexo char(1),
    codigoEndereco int
);

alter table nutricionista
add constraint fkNutricionistaEndereco foreign key(codigoEndereco) references endereco(codigoEndereco);

create table plano(
	codigoPlano int primary key,
    cpf char(11),
    dataPlano date,
    objetivo char(1),
    cpfNutricionista varchar(50)
);

alter table plano
add constraint fkPlanoCpf foreign key(cpf) references paciente (cpf);
alter table plano
add constraint fkPlanoCpfNutricionista foreign key (cpfNutricionista) references nutricionista (cpfNutricionista);

create table consulta(
	codigoConsulta int auto_increment primary key,
    codigoPlano int,
    dataConsulta date,
    peso float,
    altura int,
    nivelAtividade char(1),
    taxaMetabolicaBasal float,
    gastoEnergeticoTotal float,
    numeroRefeicoes int,
    circunferenciaAbdominal float,
    circunferenciaBraco float,
    circunferenciaPerna float,
    medidaGorduraBarriga float,
    medidaGorduraCostas float,
    valorDiarioProteina float,
    valorDiarioCarboidrato float,
    valorDiarioGordura float
    );
    
alter table consulta 
add constraint fkConsultaCodigoPlano foreign key (codigoPlano) references plano(codigoPlano);
    
create table nutrientes(
	codigoNutrientes int auto_increment primary key,
    nomeNutriente varchar(50)
    );

create table alimentos(
	codigoAlimento int auto_increment primary key,
    nomeAlimento varchar(20),
    porcaoAlimento int 
    );
    
create table nutrientesAlimentos(
	codigoNutrientes int,
    codigoAlimento int,
    grama int,
    kcal int
    );

alter table nutrientesAlimentos 
add constraint fkNutrientesAlimentosCodigoNutrientes foreign key (codigoNutrientes) references nutrientes (codigoNutrientes);
alter table nutrientesAlimentos
add constraint fkNutrientesAlimentosCodigoAlimentos foreign key (codigoAlimento) references alimentos(codigoAlimento);

create table tipoRefeicao(
	codigoTipoRefeicao int auto_increment primary key,
    nomeRefeicao varchar(25)
	);

create table refeicao(
	codigoTipoRefeicao int,
    codigoConsulta int,
    primary key(codigoTipoRefeicao,codigoConsulta)
	);
    
alter table refeicao
add constraint fkRefeicaoCodigoTipoRefeicao foreign key (codigoTipoRefeicao) references tipoRefeicao(codigoTipoRefeicao);
alter table refeicao
add constraint fkRefeicaoConsulta foreign key (codigoConsulta) references consulta(codigoConsulta);

create table itensRefeicao(
	codigoTipoRefeicao int,
    codigoConsulta int,
    codigoAlimento int,
    porcao int,
    primary key(codigoTipoRefeicao,codigoConsulta,codigoAlimento)
    );

alter table itensRefeicao 
add constraint fkItensRefeicaoCodigoTipoRefeicao foreign key (codigoTipoRefeicao) references tipoRefeicao(codigoTipoRefeicao);
alter table itensRefeicao
add constraint fkItensRefeicaoCodigoConsulta foreign key (codigoConsulta) references consulta(codigoConsulta);
alter table itensRefeicao
add constraint fkItensRefeicaoCodigoAlimento foreign key (codigoAlimento) references alimentos(codigoAlimento);

select * from itensRefeicao;