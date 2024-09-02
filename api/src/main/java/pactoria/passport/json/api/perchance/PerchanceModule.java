package pactoria.passport.json.api.perchance;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.Module;

public class PerchanceModule extends Module {

    public final static boolean DEFAULT_READ_NULL_AS_ABSENT = false;
    private boolean readNullAsAbsent = DEFAULT_READ_NULL_AS_ABSENT;

    @Override
    public String getModuleName() {
        return "PerchanceModule";
    }

    @Override
    public Version version() {
        return new Version(1, 0, 0, null, null, null);
    }

    @Override
    public void setupModule(SetupContext setupContext) {
        setupContext.addSerializers(new PerchanceSerializers());
        setupContext.addDeserializers(new PerchanceDeserializers(readNullAsAbsent));
        setupContext.addTypeModifier(new PerchanceTypeModifier());
    }

    public PerchanceModule configureReadNullAsAbsent(boolean value) {
        this.readNullAsAbsent = value;
        return this;
    }
}
