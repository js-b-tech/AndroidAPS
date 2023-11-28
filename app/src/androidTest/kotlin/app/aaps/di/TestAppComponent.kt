package app.aaps.di

import app.aaps.core.objects.di.CoreModule
import app.aaps.core.validators.di.ValidatorsModule
import app.aaps.database.impl.di.TestDatabaseModule
import app.aaps.database.persistence.di.PersistenceModule
import app.aaps.implementation.di.ImplementationModule
import app.aaps.plugins.aps.di.ApsModule
import app.aaps.plugins.automation.di.AutomationModule
import app.aaps.plugins.configuration.di.ConfigurationModule
import app.aaps.plugins.constraints.di.PluginsConstraintsModule
import app.aaps.plugins.insulin.di.InsulinModule
import app.aaps.plugins.main.di.PluginsModule
import app.aaps.plugins.source.di.SourceModule
import app.aaps.plugins.sync.di.OpenHumansModule
import app.aaps.plugins.sync.di.SyncModule
import app.aaps.pump.insight.di.InsightDatabaseModule
import app.aaps.pump.insight.di.InsightModule
import app.aaps.pump.virtual.di.VirtualPumpModule
import app.aaps.shared.impl.di.LoggerModule
import app.aaps.shared.impl.di.SharedImplModule
import app.aaps.ui.di.UiModule
import app.aaps.workflow.di.WorkflowModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import info.nightscout.androidaps.danar.di.DanaRModule
import info.nightscout.androidaps.plugins.pump.common.di.RileyLinkModule
import info.nightscout.androidaps.plugins.pump.eopatch.dagger.EopatchModule
import info.nightscout.androidaps.plugins.pump.medtronic.di.MedtronicModule
import info.nightscout.androidaps.plugins.pump.omnipod.dash.di.OmnipodDashModule
import info.nightscout.androidaps.plugins.pump.omnipod.eros.di.OmnipodErosModule
import info.nightscout.pump.combov2.di.ComboV2Module
import info.nightscout.pump.common.di.PumpCommonModule
import app.aaps.pump.dana.di.DanaHistoryModule
import app.aaps.pump.dana.di.DanaModule
import info.nightscout.pump.danars.di.DanaRSModule
import info.nightscout.pump.diaconn.di.DiaconnG8Module
import info.nightscout.pump.medtrum.di.MedtrumModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        // Inject TestApplication
        TestModule::class,
        TestsInjectionModule::class,
        // Common modules
        AndroidInjectionModule::class,

        PluginsListModule::class,
        ActivitiesModule::class,
        ReceiversModule::class,
        PersistenceModule::class,

        // Gradle modules
        AutomationModule::class,
        ApsModule::class,
        ConfigurationModule::class,
        CoreModule::class,
        // -> DatabaseModule::class, replace by in-memory database
        TestDatabaseModule::class,
        ImplementationModule::class,
        InsulinModule::class,
        OpenHumansModule::class,
        PluginsModule::class,
        SharedImplModule::class,
        LoggerModule::class,
        UiModule::class,
        ValidatorsModule::class,
        PluginsConstraintsModule::class,
        SourceModule::class,
        SyncModule::class,
        WorkflowModule::class,

        // pumps
        ComboV2Module::class,
        DanaHistoryModule::class,
        DanaModule::class,
        DanaRModule::class,
        DanaRSModule::class,
        DiaconnG8Module::class,
        EopatchModule::class,
        InsightModule::class,
        InsightDatabaseModule::class,
        MedtronicModule::class,
        OmnipodDashModule::class,
        OmnipodErosModule::class,
        PumpCommonModule::class,
        RileyLinkModule::class,
        MedtrumModule::class,
        VirtualPumpModule::class
    ]
)
interface TestAppComponent : AndroidInjector<TestApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(mainApp: TestApplication): Builder

        fun build(): TestAppComponent
    }
}