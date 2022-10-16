import com.cloudbees.groovy.cps.NonCPS

def version = '1.0'

@NonCPS
def call() {

        def resultado = new StringBuilder()
        def error     = new StringBuilder()
        def curlcommand = "curl -u apulijala12:ATBBYqUr2H6ebptZbcF4ntrbdwES01B578A9 https://api.bitbucket.org/2.0/repositories/informa-ge/informa-aem-commons.git/refs/branches?pagelen=10&page=7"
        def comando = curlcommand.execute()
        comando.consumeProcessOutput(resultado, error)
        // println(resultado.toString())
        comando.waitForOrKill(3000) //(4)

        // println(resultado.toString())
        def jsonVals = new groovy.json.JsonSlurper().parseText(resultado.toString())
        def branches = []
        for (myval in jsonVals.values) {
            branches.add("\'" + myval.name + "\'")
        }
        // println(branches)
    return branches
}

return this;
